$wnd.showcase.runAsyncCallback11("function Ikc(){}\nfunction Kkc(){}\nfunction Dkc(a,b){a.b=b}\nfunction Ekc(a){if(a==tkc){return true}nC();return a==wkc}\nfunction Fkc(a){if(a==skc){return true}nC();return a==rkc}\nfunction Jkc(a){this.b=(lmc(),gmc).a;this.e=(qmc(),pmc).a;this.a=a}\nfunction Ckc(a,b){var c;c=hgb(a.fb,180);c.e=b.a;!!c.d&&xfc(c.d,b)}\nfunction Bkc(a,b){var c;c=hgb(a.fb,180);c.b=b.a;!!c.d&&vfc(c.d,b)}\nfunction xkc(){xkc=LDb;qkc=new Ikc;tkc=new Ikc;skc=new Ikc;rkc=new Ikc;ukc=new Ikc;vkc=new Ikc;wkc=new Ikc}\nfunction Gkc(){xkc();zfc.call(this);this.b=(lmc(),gmc);this.c=(qmc(),pmc);(hcc(),this.e)[gUc]=0;this.e[hUc]=0}\nfunction ykc(a,b,c){var d;if(c==qkc){if(b==a.a){return}else if(a.a){throw fDb(new xDc('Only one CENTER widget may be added'))}}Sh(b);zwc(a.j,b);c==qkc&&(a.a=b);d=new Jkc(c);b.fb=d;Bkc(b,a.b);Ckc(b,a.c);Akc(a);Uh(b,a)}\nfunction zkc(a){var b,c,d,e,f,g,h;gwc((hcc(),a.hb),'',HVc);g=new lLc;h=new Jwc(a.j);while(h.b<h.c.c){b=Hwc(h);f=hgb(b.fb,180).a;d=hgb(pGc(DLc(g.d,f)),111);c=!d?1:d.a;e=f==ukc?'north'+c:f==vkc?'south'+c:f==wkc?'west'+c:f==rkc?'east'+c:f==tkc?'linestart'+c:f==skc?'lineend'+c:NSc;gwc(Wo(b.hb),HVc,e);BGc(g,f,KDc(c+1))}}\nfunction Akc(a){var b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r;b=(hcc(),a.d);while(Ndc(b)>0){Co(b,Mdc(b,0))}o=1;e=1;for(i=new Jwc(a.j);i.b<i.c.c;){d=Hwc(i);f=hgb(d.fb,180).a;f==ukc||f==vkc?++o:(f==rkc||f==wkc||f==tkc||f==skc)&&++e}p=qfb(nxb,HPc,291,o,0,1);for(g=0;g<o;++g){p[g]=new Kkc;p[g].b=$doc.createElement(eUc);yo(b,occ(p[g].b))}k=0;l=e-1;m=0;q=o-1;c=null;for(h=new Jwc(a.j);h.b<h.c.c;){d=Hwc(h);j=hgb(d.fb,180);r=$doc.createElement(fUc);j.d=r;j.d[VTc]=j.b;j.d.style[WTc]=j.e;j.d[ZPc]=j.f;j.d[YPc]=j.c;if(j.a==ukc){kcc(p[m].b,r,p[m].a);yo(r,occ(d.hb));r[YUc]=l-k+1;++m}else if(j.a==vkc){kcc(p[q].b,r,p[q].a);yo(r,occ(d.hb));r[YUc]=l-k+1;--q}else if(j.a==qkc){c=r}else if(Ekc(j.a)){n=p[m];kcc(n.b,r,n.a++);yo(r,occ(d.hb));r[IVc]=q-m+1;++k}else if(Fkc(j.a)){n=p[m];kcc(n.b,r,n.a);yo(r,occ(d.hb));r[IVc]=q-m+1;--l}}if(a.a){n=p[m];kcc(n.b,c,n.a);yo(c,occ(fh(a.a)))}}\nvar HVc='cwDockPanel';KDb(453,1,MSc);_.Ec=function CWb(){var a,b,c;cGb(this.a,(a=new Gkc,(hcc(),a.hb).className='cw-DockPanel',a.e[gUc]=4,Dkc(a,(lmc(),fmc)),ykc(a,new djc('This is the first north component'),(xkc(),ukc)),ykc(a,new djc('This is the first south component'),vkc),ykc(a,new djc('This is the east component'),rkc),ykc(a,new djc('This is the west component'),wkc),ykc(a,new djc('This is the second north component'),ukc),ykc(a,new djc('This is the second south component'),vkc),b=new djc(\"This is a <code>ScrollPanel<\\/code> contained at the center of a <code>DockPanel<\\/code>.  By putting some fairly large contents in the middle and setting its size explicitly, it becomes a scrollable area within the page, but without requiring the use of an IFRAME.<br><br>Here's quite a bit more meaningless text that will serve primarily to make this thing scroll off the bottom of its visible area.  Otherwise, you might have to make it really, really small in order to see the nifty scroll bars!\"),c=new ygc(b),c.hb.style[ZPc]='400px',c.hb.style[YPc]='100px',ykc(a,c,qkc),zkc(a),a))};KDb(911,283,cQc,Gkc);_.gc=function Hkc(a){var b;b=tec(this,a);if(b){a==this.a&&(this.a=null);Akc(this)}return b};var qkc,rkc,skc,tkc,ukc,vkc,wkc;var oxb=bDc(aQc,'DockPanel',911);KDb(179,1,{},Ikc);var lxb=bDc(aQc,'DockPanel/DockLayoutConstant',179);KDb(180,1,{180:1},Jkc);_.c='';_.f='';var mxb=bDc(aQc,'DockPanel/LayoutData',180);KDb(291,1,{291:1},Kkc);_.a=0;var nxb=bDc(aQc,'DockPanel/TmpRow',291);mPc(Fl)(11);\n//# sourceURL=showcase-11.js\n")
