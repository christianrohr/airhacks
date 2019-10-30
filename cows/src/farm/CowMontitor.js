import { EVENT } from './../cow/CowCommunicator.js';
class CowMonitor extends HTMLElement { 

    constructor() { 
        super();
        this.state = "unknown";
        window.addEventListener(EVENT,e => this.onUpdate(e));
    }

    onUpdate({ detail }) { 
        this.state = JSON.stringify(detail.cow);
        this.render();
    }

    async connectedCallback() { 
        this.render();
    }

    render() { 
        this.innerHTML = `
         <h2>${this.state}</h2>
        `;
    }
}

customElements.define('cow-monitor',CowMonitor);