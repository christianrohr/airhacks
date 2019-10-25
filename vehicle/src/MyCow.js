import  GpsDevice from  './GpsDevice.js';
import { html, render } from './lit-html/lit-html.js';

class MyCow extends HTMLElement { 

    constructor() { 
        super();
        console.log('initialized');
        this.buttonCaption = "Click ME";
        this.martin = "chief"
        this.root = this.attachShadow({mode:"open"});

    }

    connectedCallback() { 
        const gps = new GpsDevice();
        gps.message = 'not happy';
        const template = html`
        <style>
        .chief{
            font-size: 3em;
            color: var(--ff-base-color,pink);
        }
        </style>
            <input name="martin" placeholder="bind me" value=${this.martin} @change=${e => this.martinChanged(e)}>
            <h2 class=${this.martin}>milk</h2>
            ${gps}
            <button @click=${_ => this.buttonClicked()}>${this.buttonCaption} ${this.getAttribute('cowname')}</button>
        `;
        render(template,this.root);
    }

    buttonClicked() { 
        console.log('clicked');
    }

    disconnectedCallback() { 
        console.log('cleanup');
    }

    martinChanged(e) { 
        const { name,value } = e.target;
        console.log('changed', name, value);
        
        const model = {};

        model[name] = value;
        console.dir(model);
        
    }


}
customElements.define('my-cow',MyCow);