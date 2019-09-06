


export function txrReducer(state = {}, action) {
    let { type } = action;
    switch (type) {
        case 'TXR_SUCCESS': {
            let { status } = action
            let { message, account } = status
            return { message, account }
        }
        case 'TXR_FAILED': {
            let { error } = action
            return { ...state, message: error.message }
        }
        case 'LOAD_ACCOUNT_SUCCESS': {
            let { account } = action;
            return { account }
        }
        default: return state
    }
}