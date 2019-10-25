const cowLoader = async _ => { 
    
    const response = await fetch('cow.json');
    const json = await response.json();
    const cowEvent = new CustomEvent(EVENT, {
        detail: {
            cow: json
        },
        bubbles:true
    });
    window.dispatchEvent(cowEvent);
}

const EVENT = 'cow-loaded';
export { cowLoader,EVENT };