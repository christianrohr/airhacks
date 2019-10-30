import { html, render } from './../lit-html/lit-html.js';
import { cowLoader } from './CowCommunicator.js'
class MyCow extends HTMLElement { 


    connectedCallback() { 
        this.render();
    }

    render() { 
        const template = html`
            <h2>hello</h2>
            <button @click=${_ => this.loadCow()}>click </button>
            <output>result</output>
        `;
        render(template,this);
    }

    loadCow() { 
        cowLoader();
    }
}
customElements.define('my-cow',MyCow);