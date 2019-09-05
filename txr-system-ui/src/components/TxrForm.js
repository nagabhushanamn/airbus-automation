
import React, { useState } from 'react';
import AccountBalance from './AccountBalance';

const TxrForm = ({ onSubmit }) => {
    const [status, setStatus] = useState('')
    const [amount, setAmount] = useState('')
    const [fromAccNumber, setFromAccNumber] = useState('1')
    const [toAccNumber, setToAccNumber] = useState('')
    const handleSubmit = e => {
        e.preventDefault();
        setStatus("Txring...")
        const formData = { amount, fromAccNumber, toAccNumber }
        if (onSubmit) {
            onSubmit({ value: formData })
        }
    };
    return (
        <div className="row">
            <div className="col-sm-5 col-md-5">
                <div className="card">
                    <div className="card-header">Txr Form</div>
                    <div className="card-body">
                        <hr />
                        <AccountBalance />
                        <hr />
                        {status ? <div className="alert alert-warning">{status}</div> : null}
                        <hr />
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

export default TxrForm;