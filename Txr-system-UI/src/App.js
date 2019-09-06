import React, { useEffect } from 'react';
import './App.css';
import TxrForm from './components/TxrForm';
import AccountBalance from './components/AccountBalance';
import TxrStatus from './components/TxrStatus';

import { loadAccount } from './actions/account'

import { connect } from 'react-redux'

function App({ loadAccount }) {

  useEffect(() => {
    loadAccount('1')
  })

  return (
    <div className="container">
      <hr />
      <h1>Txr-system</h1>
      <hr />
      <TxrStatus />
      <div className="row">
        <div className="col-sm-8 col-md-8">
          <TxrForm />
        </div>
        <div className="col-sm-4 col-md-4">
          <AccountBalance />
        </div>
      </div>
    </div>
  );
}

const mapDispatchToProps = { loadAccount }
export default connect(null, mapDispatchToProps)(App);
