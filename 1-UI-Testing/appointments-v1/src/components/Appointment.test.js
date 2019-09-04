
import React from 'react';
import ReactDOM from 'react-dom';
import Appointment from './Appointment'

//test suite
describe('Appointment', () => {
    // test case ==> ( test | it )
    let customer;
    let container;
    beforeEach(() => {
        container = document.createElement('div');
    });
    const render = component => ReactDOM.render(component, container);
    it('renders the customer first name', () => {
        customer = { firstName: 'Ashley' }; // data
        render(<Appointment customer={customer} />) // react-component
        expect(container.textContent).toMatch('Ashley');
    });
    it('renders another customer first name', () => {
        customer = { firstName: 'Jordan' };
        render(<Appointment customer={customer} />);
        expect(container.textContent).toMatch('Jordan');
    });
}); 