//
// Generated by JTB 1.3.2
//

package jp.go.aist.rtm.rtcbuilder.corba.idl.parser.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "raises"
 * nodeToken1 -> "("
 * scoped_name -> scoped_name()
 * nodeListOptional -> ( "," scoped_name() )*
 * nodeToken2 -> ")"
 */
public class raises_expr implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public scoped_name scoped_name;
   public NodeListOptional nodeListOptional;
   public NodeToken nodeToken2;

   public raises_expr(NodeToken n0, NodeToken n1, scoped_name n2, NodeListOptional n3, NodeToken n4) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = n1;
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      scoped_name = n2;
      if ( scoped_name != null ) scoped_name.setParent(this);
      nodeListOptional = n3;
      if ( nodeListOptional != null ) nodeListOptional.setParent(this);
      nodeToken2 = n4;
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
   }

   public raises_expr(scoped_name n0, NodeListOptional n1) {
      nodeToken = new NodeToken("raises");
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = new NodeToken("(");
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      scoped_name = n0;
      if ( scoped_name != null ) scoped_name.setParent(this);
      nodeListOptional = n1;
      if ( nodeListOptional != null ) nodeListOptional.setParent(this);
      nodeToken2 = new NodeToken(")");
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
   }

   public void accept(jp.go.aist.rtm.rtcbuilder.corba.idl.parser.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(jp.go.aist.rtm.rtcbuilder.corba.idl.parser.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(jp.go.aist.rtm.rtcbuilder.corba.idl.parser.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(jp.go.aist.rtm.rtcbuilder.corba.idl.parser.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}

