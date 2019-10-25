const serverCall = (uri) => { 
    fetch('vehicle.json').then(r => r.json()).then(result => console.log(result));
    
}

console.log(serverCall());