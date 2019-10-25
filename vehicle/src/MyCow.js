class MyCow extends HTMLElement { 

    constructor() { 
        super();
        console.log('initialized');
        this.buttonCaption = "Click ME";
        this.martin = "chief"
        this.root = this.attachShadow({mode:"open"});

    }

    connectedCallback() { 
        console.log('inside DOM');
        this.root.innerHTML = `
        <style>
        .chief{
            font-size: 3em;
            color: var(--ff-base-color,pink);
        }
        

        </style>
            <h2 class=${this.martin}>milk</h2>
            <button>${this.buttonCaption} ${this.getAttribute('cowname')}</button>
        `;
        this.button = this.root.querySelector("button");
        this.button.onclick = _ => this.buttonClicked();
        console.dir(this);
    }

    buttonClicked() { 
        console.log('clicked');
    }

    disconnectedCallback() { 
        console.log('cleanup');
    }


}
customElements.define('my-cow',MyCow);