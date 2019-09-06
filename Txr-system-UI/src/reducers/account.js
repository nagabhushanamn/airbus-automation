


export function accountReducer(state = {}, action) {
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
        default: return state
    }
}