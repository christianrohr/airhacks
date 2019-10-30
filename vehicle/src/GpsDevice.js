export default class GpsDevice extends HTMLElement { 


    constructor() { 
        super();
        this.root = this.attachShadow({mode:'open'});
    }

    connectedCallback() { 
        this.render();
    }

    set message(msg) { 
        this.setAttribute('message',msg);
    }

    get message() { 
        return this.getAttribute('message') || 'happy';
    }

    render() { 
        this.root.innerHTML = `
        <h2>${this.message}</h2>
    `;
    }
}

customElements.define('gps-device',GpsDevice);