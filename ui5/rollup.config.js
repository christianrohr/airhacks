import resolve from 'rollup-plugin-node-resolve';
export default {
  input: 'node_modules/@ui5/webcomponents/dist/DatePicker.js',
  output: {
    file: './dist/DatePicker.js',  
    format: 'esm',
    name: 'ui5'
  },
  plugins: [
    resolve({
      jsnext:true
//      mainFields: ['jsnext:main']
    })
  ]
};