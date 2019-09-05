

import React from 'react'
import ReactDOM from 'react-dom'
import ReactTestUtils from 'react-dom/test-utils'

import sinon from 'sinon'

import TxrForm from './TxrForm'

import Enzyme, { shallow, mount, render } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

Enzyme.configure({ adapter: new Adapter() });


describe.skip('TxrForm', () => {

    // #1 -> shallow rendering
    it('renders header ', () => {
        const wrapper = shallow(<TxrForm />)
        expect(wrapper.find('.card-header').text()).toEqual('Txr Form')
    })

    it('should return default form-data', () => {
        const callback = sinon.fake();
        const wrapper = shallow(<TxrForm onSubmit={callback} />)
        wrapper.find('#txr-form').simulate('submit', { preventDefault: sinon.fake() })
        const expected = { value: { amount: '', fromAccNum: '', toAccNumber: '' } }
        expect(callback.calledOn(expected))
    })

    it('should return form-data', () => {
        const callback = sinon.fake();
        const wrapper = shallow(<TxrForm onSubmit={callback} />)
        wrapper.find('#txr-form').simulate('submit', { preventDefault: sinon.fake() })
        wrapper.find('#fromAccNumber').simulate('change', { target: { id: 'fromAccNumber', value: '1' } });
        const expected = { value: { amount: '', fromAccNum: '1', toAccNumber: '' } }
        expect(callback.calledOn(expected))
    })


    // #2 -> full rendering
    it('should render account balance', () => {
        const callback = sinon.fake();
        const wrapper = mount(<TxrForm onSubmit={callback} />)
        // console.log(wrapper.debug());
        expect(wrapper.find('.alert .badge-danger').text()).toBe("1000.00")
    })

    // #3 -> static rendering
    it('should render account balance', () => {
        const callback = sinon.fake();
        const wrapper = render(<TxrForm onSubmit={callback} />)
        console.log(wrapper.html());
    })


})
