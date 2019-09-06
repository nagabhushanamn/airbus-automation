
import React, { useState } from 'react';

import { connect } from 'react-redux';
import { txr } from '../actions/txr'

export const TxrForm = ({ onSubmit, txr, message }) => {
    const [amount, setAmount] = useState(100)
    const [fromAccNumber, setFromAccNumber] = useState('1')
    const [toAccNumber, setToAccNumber] = useState('2')
    const handleSubmit = e => {
        e.preventDefault();
        const formData = { amount, fromAccNumber, toAccNumber }
        if (onSubmit) {
            onSubmit({ value: formData })
        }
        txr(formData)
    };
    return (
        <div className="row">
            <div className="col-sm-8 col-md-8">
                <div className="card">
                    <div className="card-header">Txr Form</div>
                    <div className="card-body">
                        <form id="txr-form" onSubmit={e => handleSubmit(e)}>
                            <div className="form-group">
                                <label htmlFor="fromAccNumber">Amount</label>
                                <input
                                    id="amount"
                                    type="number"
                                    value={amount}
                                    className="form-control"
                                    onChange={e => setAmount(e.target.value)}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="fromAccNumber">From Account</label>
                                <input
                                    id="fromAccNumber"
                                    type="number"
                                    value={fromAccNumber}
                                    className="form-control"
                                    onChange={e => setFromAccNumber(e.target.value)}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="toAccNumber">To Account</label>
                                <input
                                    id="toAccNumber"
                                    type="number"
                                    value={toAccNumber}
                                    className="form-control"
                                    onChange={e => setToAccNumber(e.target.value)}
                                />
                            </div>
                            <button className="btn btn-dark">Txr</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    );
};


const mapStateToProps = (state) => {
    return {
        message: state.txr.message || ''
    }
}
const mapDispatchToProps = { txr }

export default connect(mapStateToProps, mapDispatchToProps)(TxrForm);