
import txrApi from '../api/txr'

export function txr(formData) {
    return function (dispatch) {
        txrApi.post('txr', formData)
            .then(response => response.data)
            .then(status => {
                dispatch({ type: "TXR_SUCCESS", status })
            })
            .catch(error => {
                dispatch({ type: "TXR_FAILED", error })
            })
    }
}