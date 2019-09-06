


export function add(n1, n2) {
    return n1 + n2;
}


export function addAsync(n1, n2) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(n1 + n2)
        }, 1000);
    })
}

