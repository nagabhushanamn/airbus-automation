
import accountApi from '../api/account'

export function loadAccount(number) {
    return function (dispatch) {
        accountApi.get("/accounts/" + number)
            .then(response => response.data)
            .then(account => {
                dispatch({ type: 'LOAD_ACCOUNT_SUCCESS', account })
            })
    }
}