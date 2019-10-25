const serverCall = async (uri) => { 
    try {
        const response = await fetch('vehicl.json');
        const payload = await response.json();
        const { name, power } = payload;
    } catch (error) { 
        console.log('problem with fetch',error);
    }
    //console.log(name,power);
    
}

console.log(serverCall());