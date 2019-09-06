

import React from 'react'
import renderer from 'react-test-renderer';
import {TxrForm} from './TxrForm'

test('TxrForm snapshot', () => {
    const tree = renderer.create(<TxrForm />)
    expect(tree).toMatchSnapshot()
})
