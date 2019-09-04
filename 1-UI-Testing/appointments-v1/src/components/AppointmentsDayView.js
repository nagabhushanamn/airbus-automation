

import React, { useState } from 'react';
import Appointment from './Appointment'

const appointmentTimeOfDay = startsAt => {
    const [h, m] = new Date(startsAt).toTimeString().split(':');
    return `${h}:${m}`;
}

const AppointmentsDayView = ({ appointments }) => {
    const [selectedAppointment, setSelectedAppointment] = useState(0); // React 15
    return (
        <div id="appointmentsDayView">
            <div className="row">
                <div className="col-3 col-sm-3 col-md-3">
                    <ol style={{ listStyle: 'none' }}>
                        {
                            appointments.map((appointment, i) => {
                                return (
                                    <li key={appointment.startsAt} style={{cursor:'pointer'}} className="list-group-item" onClick={e => setSelectedAppointment(i)}>
                                        {appointmentTimeOfDay(appointment.startsAt)}
                                    </li>
                                )
                            })
                        }
                    </ol>
                </div>
                <div className="col-9 col-sm-9 col-md-9">
                    {appointments.length === 0 ? (
                        <p>There are no appointments scheduled for today.</p>
                    ) : (
                            <Appointment {...appointments[selectedAppointment]} />
                        )}
                </div>
            </div>




        </div>
    );
};

export default AppointmentsDayView;