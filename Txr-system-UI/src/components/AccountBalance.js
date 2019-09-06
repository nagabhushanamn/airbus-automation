

import React from 'react';
import { connect } from 'react-redux'

export const AccountBalance = ({ account }) => {
    return (
        <div className="card">
            <div className="card-header">Account Details</div>
            <div className="card-body">
                number  : <span className="badge">{account.number}</span>
                <br />
                balance : <span id="balance" className="badge">{account.balance}</span>
            </div>
        </div>
    );
};

const mapStateToProps = (state) => {
    return {
        account: state.txr.account || {}
    }
}

export default connect(mapStateToProps)(AccountBalance);