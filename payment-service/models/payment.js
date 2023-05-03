const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const paymentSchema = new Schema({
  id: { type: Number, required: true },
  amount: { type: Number, required: true },
  username: { type: String, required: true },
  credit_card: { type: String, required: true }
});

const Payment = mongoose.model('Payment', paymentSchema);

module.exports = Payment;
