
import { defineFeature, loadFeature } from 'jest-cucumber';
import { add } from '../util/calc'

const feature = loadFeature('./sum_a_pair_v1.feature', { loadRelativePath: true });

defineFeature(feature, test => {

    test('adds 1 + 2 to equal 3', ({ given, when, then }) => {

        let x;
        let z;

        given('1', () => {
            x = 1;
        });

        when('add 2', () => {
            z = add(x, 2);
        });

        then('the sum is 3', () => {
            expect(z).toBe(3);
        });

    });
});