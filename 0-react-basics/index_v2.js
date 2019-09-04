console.log("-index_v2.js-");

let asiaKolkata_v2 = document.querySelector("#asia_kolkata_v2");
let asiaDubai_v2 = document.querySelector("#asia_dubai_v2");
let americaNewyork_v2 = document.querySelector("#america_newyork_v2");


//----------------------------------------------------
// way-2 : react-js
//----------------------------------------------------

/**
 * 
        <div className="card">
            <div className="card-header">${timeZone}</div>
            <div className="card-body">
                <span className="badge badge-dark">
                    ${new Date().toLocaleTimeString('en-US', { timeZone })}
                </span>
            </div>
        </div>
}
 * 
 */

function NewClock(props) {
    let { timeZone } = props;
  
    // let div1 = React.createElement('div', { className: 'card-header' }, timeZone)
    // let span = React.createElement('span', { className: 'badge badge-dark' }, new Date().toLocaleTimeString('en-US', { timeZone }))
    // let div2 = React.createElement('div', { className: 'card-body' }, span)
    // let div = React.createElement('div', { className: 'card' }, div1, div2)
    // return div;

    return (
        <div className="card">
            <div className="card-header">{timeZone}</div>
            <div className="card-body">
                <span className="badge badge-dark">
                    {new Date().toLocaleTimeString('en-US', { timeZone })}
                </span>
            </div>
        </div>
    )

}


setInterval(() => {
    ReactDOM.render(NewClock({ timeZone: 'Asia/Kolkata' }), asiaKolkata_v2)
    ReactDOM.render(NewClock({ timeZone: 'Asia/Dubai' }), asiaDubai_v2)
    ReactDOM.render(NewClock({ timeZone: 'America/New_york' }), americaNewyork_v2)
}, 1000);

