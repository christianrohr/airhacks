import resolve from 'rollup-plugin-node-resolve';
export default {
  input: 'node_modules/@ui5/webcomponents/dist/Table.js',
  output: {
    file: './dist/Table.js',  
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