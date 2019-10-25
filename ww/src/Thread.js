self.onmessage = async e => { 
    console.log('event received', e);
    const response = await fetch(`${e.data}.json`);
    const { name } = await response.json();
    postMessage({greetings:"from worker " + name})
}

