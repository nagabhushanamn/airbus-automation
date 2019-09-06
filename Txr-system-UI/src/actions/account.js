
import txrApi from '../api/txr'

export function txr(formData) {
    return function (dispatch) {
        txrApi.post('/txr', formData)
            .then(result => {
                dispatch({ type: "TXR_SUCCESS", status: result })
            })
            .catch(error => {
                dispatch({ type: "TXR_FAILED", error })
            })
    }
}