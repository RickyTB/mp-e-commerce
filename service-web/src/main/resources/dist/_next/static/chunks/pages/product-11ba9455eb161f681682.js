(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[345],{9226:function(e,t,i){"use strict";var n=i(1354);const o=(0,i(8702).Z)(),r=(0,n.Z)({defaultTheme:o});t.Z=r},4065:function(e,t,i){"use strict";i.d(t,{Z:function(){return g}});var n=i(9756),o=i(2122),r=i(7294),a=(i(5697),i(6010)),s=i(7463),d=i(6122),c=i(9602),u=i(1420);function m(e){return(0,u.Z)("MuiContainer",e)}(0,i(1271).Z)("MuiContainer",["root","disableGutters","fixed","maxWidthXs","maxWidthSm","maxWidthMd","maxWidthLg","maxWidthXl"]);var l=i(8216),x=i(5893);const p=["className","component","disableGutters","fixed","maxWidth"],h=(0,c.ZP)("div",{name:"MuiContainer",slot:"Root",overridesResolver:(e,t)=>{const{ownerState:i}=e;return[t.root,t[`maxWidth${(0,l.Z)(String(i.maxWidth))}`],i.fixed&&t.fixed,i.disableGutters&&t.disableGutters]}})((({theme:e,ownerState:t})=>(0,o.Z)({width:"100%",marginLeft:"auto",boxSizing:"border-box",marginRight:"auto",display:"block"},!t.disableGutters&&{paddingLeft:e.spacing(2),paddingRight:e.spacing(2),[e.breakpoints.up("sm")]:{paddingLeft:e.spacing(3),paddingRight:e.spacing(3)}})),(({theme:e,ownerState:t})=>t.fixed&&Object.keys(e.breakpoints.values).reduce(((t,i)=>{const n=e.breakpoints.values[i];return 0!==n&&(t[e.breakpoints.up(i)]={maxWidth:`${n}${e.breakpoints.unit}`}),t}),{})),(({theme:e,ownerState:t})=>(0,o.Z)({},"xs"===t.maxWidth&&{[e.breakpoints.up("xs")]:{maxWidth:Math.max(e.breakpoints.values.xs,444)}},t.maxWidth&&"xs"!==t.maxWidth&&{[e.breakpoints.up(t.maxWidth)]:{maxWidth:`${e.breakpoints.values[t.maxWidth]}${e.breakpoints.unit}`}})));var g=r.forwardRef((function(e,t){const i=(0,d.Z)({props:e,name:"MuiContainer"}),{className:r,component:c="div",disableGutters:u=!1,fixed:g=!1,maxWidth:f="lg"}=i,Z=(0,n.Z)(i,p),b=(0,o.Z)({},i,{component:c,disableGutters:u,fixed:g,maxWidth:f}),v=(e=>{const{classes:t,fixed:i,disableGutters:n,maxWidth:o}=e,r={root:["root",o&&`maxWidth${(0,l.Z)(String(o))}`,i&&"fixed",n&&"disableGutters"]};return(0,s.Z)(r,m,t)})(b);return(0,x.jsx)(h,(0,o.Z)({as:c,ownerState:b,className:(0,a.Z)(v.root,r),ref:t},Z))}))},4966:function(e,t,i){"use strict";i.r(t),i.d(t,{default:function(){return P}});var n=i(5893),o=i(9756),r=i(2122),a=i(7294),s=(i(5697),i(6010)),d=i(7463),c=i(6122),u=i(9602),m=i(1420);function l(e){return(0,m.Z)("MuiCardMedia",e)}(0,i(1271).Z)("MuiCardMedia",["root","media","img"]);const x=["children","className","component","image","src","style"],p=(0,u.ZP)("div",{name:"MuiCardMedia",slot:"Root",overridesResolver:(e,t)=>{const{ownerState:i}=e,{isMediaComponent:n,isImageComponent:o}=i;return[t.root,n&&t.media,o&&t.img]}})((({ownerState:e})=>(0,r.Z)({display:"block",backgroundSize:"cover",backgroundRepeat:"no-repeat",backgroundPosition:"center"},e.isMediaComponent&&{width:"100%"},e.isImageComponent&&{objectFit:"cover"}))),h=["video","audio","picture","iframe","img"],g=["picture","img"];var f=a.forwardRef((function(e,t){const i=(0,c.Z)({props:e,name:"MuiCardMedia"}),{children:a,className:u,component:m="div",image:f,src:Z,style:b}=i,v=(0,o.Z)(i,x),j=-1!==h.indexOf(m),W=!j&&f?(0,r.Z)({backgroundImage:`url("${f}")`},b):b,k=(0,r.Z)({},i,{component:m,isMediaComponent:j,isImageComponent:-1!==g.indexOf(m)}),w=(e=>{const{classes:t,isMediaComponent:i,isImageComponent:n}=e,o={root:["root",i&&"media",n&&"img"]};return(0,d.Z)(o,l,t)})(k);return(0,n.jsx)(p,(0,r.Z)({className:(0,s.Z)(w.root,u),as:m,role:!j&&f?"image":void 0,ref:t,style:W,ownerState:k,src:j?f||Z:void 0},v,{children:a}))})),Z=i(4065),b=i(2658),v=i(5295),j=i(9226),W=i(2643),k=i(461),w=i(2642),C=i(9008),y=i(3659),M=i(1275),S=i(1163),_=i(4780),N=i(5469),P=function(){var e=(0,M.QT)(),t=e.get,i=(e.state,e.data),o=(e.error,(0,S.useRouter)().query);return(0,a.useEffect)((function(){o.id&&t("/product/products/".concat(o.id))}),[o]),i?(0,n.jsxs)(n.Fragment,{children:[(0,n.jsx)(C.default,{children:(0,n.jsx)("title",{children:"Producto | E-commerce"})}),(0,n.jsxs)(Z.Z,{maxWidth:"lg",sx:{marginTop:"72px",paddingTop:2},children:[(0,n.jsxs)(v.Z,{sx:{display:"flex",marginBottom:3},children:[(0,n.jsx)(f,{component:"img",sx:{width:300},image:"/placeholder_2.jpg",alt:"Producto"}),(0,n.jsxs)(j.Z,{sx:{display:"flex",flexDirection:"column"},children:[(0,n.jsxs)(W.Z,{sx:{flex:"1 0 auto"},children:[(0,n.jsx)(k.Z,{label:i.category.name,sx:{marginBottom:1}}),(0,n.jsx)(b.Z,{variant:"h3",component:"h1",mb:2,children:i.name}),(0,n.jsx)(b.Z,{variant:"subtitle1",color:"text.secondary",component:"p",mb:1,style:{whiteSpace:"pre-wrap"},children:i.description}),(0,n.jsxs)(b.Z,{color:"text.secondary",mb:1,children:["$",i.price.toFixed(2)]}),i.status===_.P.IN_STOCK?(0,n.jsxs)(b.Z,{variant:"body2",children:[i.quantity," disponible",1===i.quantity?"":"s"]}):(0,n.jsx)(b.Z,{variant:"body1",color:"error",children:"No disponible"})]}),i.status===_.P.IN_STOCK&&(0,n.jsx)(j.Z,{sx:{display:"flex",alignItems:"center",pl:1,pb:1},children:(0,n.jsx)(w.Z,{color:"success",startIcon:(0,n.jsx)(y.Z,{}),children:"Agregar al carrito"})})]})]}),(0,n.jsx)(N.PY,{productId:i.id})]})]}):(0,n.jsxs)(n.Fragment,{children:[(0,n.jsx)(C.default,{children:(0,n.jsx)("title",{children:"Producto no encontrado | E-commerce"})}),(0,n.jsx)(Z.Z,{maxWidth:"lg",sx:{marginTop:"72px",paddingTop:2},children:(0,n.jsx)(b.Z,{children:"El producto no se encontr\xf3"})})]})}},4548:function(e,t,i){(window.__NEXT_P=window.__NEXT_P||[]).push(["/product",function(){return i(4966)}])},1163:function(e,t,i){e.exports=i(4651)}},function(e){e.O(0,[774,888,179],(function(){return t=4548,e(e.s=t);var t}));var t=e.O();_N_E=t}]);