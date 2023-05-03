const express = require('express');
const mongoose = require('mongoose');
const paymentRoute = require('./routes/payment');

const app = express();
const dbUrl = 'mongodb://mongodb:27017/payment?directConnection=true';

var MongoClient = require('mongodb').MongoClient;
MongoClient.connect(dbUrl, function(err, db) {
  if (err) throw err;
  console.log("Database created!");
  db.close();
});

mongoose.connect(dbUrl, {
  useNewUrlParser: true,
  useUnifiedTopology: true
}).then(() => {
  console.log('Connected to MongoDB');
}).catch(err => {
  console.error('Error connecting to MongoDB', err);
});


app.use(express.json());


app.use('/payment', paymentRoute);

app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).send('Internal server error');
});

const Eureka = require('eureka-js-client').Eureka;

const eureka = new Eureka({
  instance: {
    app: 'payment',
    instanceId: 'payment-1',
    hostName: 'localhost',
    ipAddr:'127.0.0.1',
    port: {
      '$': 3000,
      '@enabled': true,
    },
    vipAddress: 'payment',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
  eureka: {
    host: 'localhost',
    port: 8761,
    servicePath: '/eureka/apps/',
  },
});

eureka.logger.level('debug')
eureka.start(error=>{
  console.log(error || "user service regiestered")
});
const port = process.env.PORT || 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});
