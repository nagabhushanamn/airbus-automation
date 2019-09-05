console.log("-index_v1.js-");

let asiaKolkata_v1 = document.querySelector("#asia_kolkata_v1");
let asiaDubai_v1 = document.querySelector("#asia_dubai_v1");
let americaNewyork_v1 = document.querySelector("#america_newyork_v1");


//----------------------------------------------------
// way-1 : plain-js
//----------------------------------------------------

function Clock(props) {
    let { timeZone } = props;
    return `
        <div class="card">
            <div class="card-header">${timeZone}</div>
            <div class="card-body">
                <span class="badge badge-dark">
                    ${new Date().toLocaleTimeString('en-US', { timeZone })}
                </span>
            </div>
        </div>
    `
}


setInterval(() => {
    asiaKolkata_v1.innerHTML = Clock({ timeZone: 'Asia/Kolkata' })
    asiaDubai_v1.innerHTML = Clock({ timeZone: 'Asia/Dubai' })
    americaNewyork_v1.innerHTML = Clock({ timeZone: 'America/New_york' })
}, 1000);
