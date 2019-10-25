import './DatePicker.js';
import { html, render } from './lit-html/lit-html.js';

class MyApp extends HTMLElement { 

    connectedCallback() { 
        const template = html`
         <ui5-datepicker @change=${e => this.onNewDate(e)} id="myDatepicker1"></ui5-datepicker> 
        `;
        render(template,this);
    }

    onNewDate({ detail }) { 
        console.log(detail.value);
    }


}

customElements.define('my-app',MyApp);



