
import { menu } from './menu'

describe('menu', () => {

    //way-1
    it("it should return biryani ", (done) => {
        const expected = "biryani"
        const promise = menu.getFood()
        promise.then(result => {
            //..
            let actual = result;
            expect(actual).toEqual(expected)
            done();
        })
    })


    // way-2
    it("it should return biryani", async () => {
        const expected = "biryani"
        const actual = await menu.getFood()
        expect(actual).toEqual(expected)
    })

})