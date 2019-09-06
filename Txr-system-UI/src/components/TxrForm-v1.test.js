

import React from 'react'
import ReactDOM from 'react-dom'
import ReactTestUtils from 'react-dom/test-utils'

import {TxrForm} from './TxrForm'



describe.skip('TxrForm', () => {

    let container;
    
    const render = component => ReactDOM.render(component, container);
    const findForm = formId => container.querySelector(`form[id="${formId}"]`)
    const findFormField = (formId, fieldId) => findForm(formId).elements[fieldId]

    beforeEach(() => {
        container = document.createElement('div')
    })

    it('renders header ', () => {
        render(<TxrForm />)
        let actual = container.querySelector('.card-header').textContent;
        expect(actual).toEqual('Txr Form')
    })

    it('should return default form-data', () => {
        expect.hasAssertions();
        let expected = { amount: '', fromAccNumber: '', toAccNumber: '' }
        const callback = e => {
            const actual = e.value;
            expect(actual).toEqual(expected)
        }
        render(<TxrForm onSubmit={callback} />)
        const form = findForm('txr-form')
        ReactTestUtils.Simulate.submit(form);
    })

    it('should return form-data', async () => {
        expect.hasAssertions();
        let expected = { amount: 100.00, fromAccNumber: '1', toAccNumber: '2' }
        const callback = e => {
            const actual = e.value;
            expect(actual).toEqual(expected)
        }
        render(<TxrForm onSubmit={callback} />)
        const form = findForm('txr-form')

        const fromAccNumberField = findFormField('txr-form', 'fromAccNumber')
        const toAccNumberField = findFormField('txr-form', 'toAccNumber')
        const amountField = findFormField('txr-form', 'amount')

        await ReactTestUtils.Simulate.change(amountField, {
            target: { value: 100 }
        });
        await ReactTestUtils.Simulate.change(fromAccNumberField, {
            target: { value: '1' }
        });
        await ReactTestUtils.Simulate.change(toAccNumberField, {
            target: { value: '2' }
        });
        
        ReactTestUtils.Simulate.submit(form);

    })




})
