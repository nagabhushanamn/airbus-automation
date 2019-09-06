

import { combineReducers } from 'redux';

import { txrReducer } from './txr';

export default combineReducers({
    txr: txrReducer
})