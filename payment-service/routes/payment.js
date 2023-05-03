const express = require('express');
const router = express.Router();
const Payment = require('../models/payment');

// Create a payment
router.post('/', (req, res) => {
  const payment = new Payment(req.body);
  payment.save((err, payment) => {
    if (err) {
      res.status(400).send(err);
    } else {
      res.send(payment);
    }
  });
});

// Read all payments
router.get('/', (req, res) => {
  Payment.find({}, (err, payments) => {
    if (err) {
      res.status(400).send(err);
    } else {
      res.send(payments);
    }
  });
});

// Read a payment by ID
router.get('/:id', (req, res) => {
  Payment.findOne({ id: req.params.id }, (err, payment) => {
    if (err) {
      res.status(400).send(err);
    } else if (!payment) {
      res.status(404).send('Payment not found');
    } else {
      res.send(payment);
    }
  });
});

router.put('/:id', (req, res) => {
  Payment.findOneAndUpdate(
    { id: req.params.id },
    {
      $set: {
        amount: req.body.amount,
        username: req.body.username,
        credit_card: req.body.credit_card
      }
    },
    { new: true },
    (err, payment) => {
      if (err) {
        res.status(400).send(err);
      } else if (!payment) {
        res.status(404).send('Payment not found');
      } else {
        res.send(payment);
      }
    }
  );
});

router.delete('/:id', (req, res) => {
  Payment.findOneAndDelete({ id: req.params.id }, (err, payment) => {
    if (err) {
      res.status(400).send(err);
    } else if (!payment) {
      res.status(404).send('Payment not found');
    } else {
      res.send(payment);
    }
  });
});

module.exports = router;