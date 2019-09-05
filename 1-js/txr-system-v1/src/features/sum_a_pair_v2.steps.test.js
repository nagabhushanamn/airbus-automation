import { defineFeature, loadFeature } from 'jest-cucumber';
import {add} from '../util/calc'

const feature = loadFeature('./sum_a_pair_v2.feature', { loadRelativePath: true });

defineFeature(feature, test => {
    test('adds x + y to equal sum', ({ given, when, then }) => {
        let x;
        let z;

        given(/^x is (.*)$/, (givenXStr) => {
            const givenX = parseInt(givenXStr, 10);
            x = givenX;
        });

        when(/^add (.*)$/, (givenYStr) => {
            const givenY = parseInt(givenYStr, 10);
            z = add(x, givenY);
        });

        then(/^the sum is (.*)$/, (givenSumStr) => {
            const givenSum = parseInt(givenSumStr, 10);
            expect(z).toBe(givenSum);
        });
    });
});