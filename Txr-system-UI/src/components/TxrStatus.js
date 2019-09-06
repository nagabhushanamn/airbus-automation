
import React from 'react';

import { connect } from 'react-redux';

const TxrStatus = ({ message }) => {
    if (message)
        return (
            <div>
                <hr />
                <div className="alert alert-warning">{message}</div>
                <hr />
            </div>
        );
    else return null;
};


const mapStateToProps = (state) => {
    return {
        message: state.txr.message || ''
    }
}

export default connect(mapStateToProps)(TxrStatus);