import React from 'react';
import './App.css';

import AppointmentsDayView from './components/AppointmentsDayView';

import { sampleAppointments } from './sampleData';

function App() {
  return (
    <div className="container">
      <hr />
      <h1>Appointments</h1>
      <hr />
      <AppointmentsDayView appointments={sampleAppointments} />
    </div>
  );
}

export default App;
