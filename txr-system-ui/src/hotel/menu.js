


export let menu = {
    getFood() {
        //...
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                resolve('biryani')
            }, 1000);
        });
    }
}