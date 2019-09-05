
import { add } from './calc'

/*
        - Arrange
        - Act
        - Assert
*/

describe('calc', () => {

    it("1+2 = 3", () => {
        const expected = 3
        const actual = add(1, 2); //  sync
        expect(actual).toBe(expected)
    })

})