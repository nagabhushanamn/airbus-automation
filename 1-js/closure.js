


function teach(sub) {
    console.log("teaching " + sub);
    let notes = sub + "-notes"
    function learn() {
        console.log("learning with " + notes);
    }
    //learn()
    console.log("teaching ends..");
    return learn;
}


let learnFunc = teach('automation')
learnFunc();