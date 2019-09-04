
import React from 'react';

const Appointment = (props) => {
    let { customer: { firstName } } = props
    return (
        <div>{firstName}</div>
    )
}

export default Appointment;
