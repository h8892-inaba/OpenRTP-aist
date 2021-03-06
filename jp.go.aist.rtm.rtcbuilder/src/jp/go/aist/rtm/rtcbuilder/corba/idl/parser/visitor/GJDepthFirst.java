//
// Generated by JTB 1.3.2
//

package jp.go.aist.rtm.rtcbuilder.corba.idl.parser.visitor;
import jp.go.aist.rtm.rtcbuilder.corba.idl.parser.syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJDepthFirst<R,A> implements GJVisitor<R,A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public R visit(NodeList n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n, A argu) {
      if ( n.present() )
         return n.node.accept(this,argu);
      else
         return null;
   }

   public R visit(NodeSequence n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n, A argu) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * nodeList -> ( definition() )+
    */
   public R visit(specification n, A argu) {
      R _ret=null;
      n.nodeList.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> type_dcl() ";"
    *       | const_dcl() ";"
    *       | except_dcl() ";"
    *       | interfacex() ";"
    *       | module() ";"
    */
   public R visit(definition n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "module"
    * identifier -> identifier()
    * nodeToken1 -> "{"
    * nodeList -> ( definition() )+
    * nodeToken2 -> "}"
    */
   public R visit(module n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeList.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> interface_dcl()
    *       | forward_dcl()
    */
   public R visit(interfacex n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * interface_header -> interface_header()
    * nodeToken -> "{"
    * interface_body -> interface_body()
    * nodeToken1 -> "}"
    */
   public R visit(interface_dcl n, A argu) {
      R _ret=null;
      n.interface_header.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.interface_body.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "interface"
    * identifier -> identifier()
    */
   public R visit(forward_dcl n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "interface"
    * identifier -> identifier()
    * nodeOptional -> [ inheritance_spec() ]
    */
   public R visit(interface_header n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeOptional.accept(this, argu);
      return _ret;
   }

   /**
    * nodeListOptional -> ( export() )*
    */
   public R visit(interface_body n, A argu) {
      R _ret=null;
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> type_dcl() ";"
    *       | const_dcl() ";"
    *       | except_dcl() ";"
    *       | attr_dcl() ";"
    *       | op_dcl() ";"
    */
   public R visit(export n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> ":"
    * scoped_name -> scoped_name()
    * nodeListOptional -> ( "," scoped_name() )*
    */
   public R visit(inheritance_spec n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.scoped_name.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * nodeOptional -> [ "::" ]
    * identifier -> identifier()
    * nodeListOptional -> ( "::" identifier() )*
    */
   public R visit(scoped_name n, A argu) {
      R _ret=null;
      n.nodeOptional.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "const"
    * const_type -> const_type()
    * identifier -> identifier()
    * nodeToken1 -> "="
    * const_exp -> const_exp()
    */
   public R visit(const_dcl n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.const_type.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.const_exp.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> integer_type()
    *       | char_type()
    *       | boolean_type()
    *       | floating_pt_type()
    *       | string_type()
    *       | scoped_name()
    */
   public R visit(const_type n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * or_expr -> or_expr()
    */
   public R visit(const_exp n, A argu) {
      R _ret=null;
      n.or_expr.accept(this, argu);
      return _ret;
   }

   /**
    * xor_expr -> xor_expr()
    * nodeListOptional -> ( "|" xor_expr() )*
    */
   public R visit(or_expr n, A argu) {
      R _ret=null;
      n.xor_expr.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * and_expr -> and_expr()
    * nodeListOptional -> ( "^" and_expr() )*
    */
   public R visit(xor_expr n, A argu) {
      R _ret=null;
      n.and_expr.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * shift_expr -> shift_expr()
    * nodeListOptional -> ( "&" shift_expr() )*
    */
   public R visit(and_expr n, A argu) {
      R _ret=null;
      n.shift_expr.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * add_expr -> add_expr()
    * nodeListOptional -> ( ( ">>" | "<<" ) add_expr() )*
    */
   public R visit(shift_expr n, A argu) {
      R _ret=null;
      n.add_expr.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * mult_expr -> mult_expr()
    * nodeListOptional -> ( ( "+" | "-" ) mult_expr() )*
    */
   public R visit(add_expr n, A argu) {
      R _ret=null;
      n.mult_expr.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * unary_expr -> unary_expr()
    * nodeListOptional -> ( ( "*" | "/" | "%" ) unary_expr() )*
    */
   public R visit(mult_expr n, A argu) {
      R _ret=null;
      n.unary_expr.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * nodeOptional -> [ unary_operator() ]
    * primary_expr -> primary_expr()
    */
   public R visit(unary_expr n, A argu) {
      R _ret=null;
      n.nodeOptional.accept(this, argu);
      n.primary_expr.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> "-"
    *       | "+"
    *       | "~"
    */
   public R visit(unary_operator n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> scoped_name()
    *       | literal()
    *       | "(" const_exp() ")"
    */
   public R visit(primary_expr n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> integer_literal()
    *       | string_literal()
    *       | character_literal()
    *       | floating_pt_literal()
    *       | boolean_literal()
    */
   public R visit(literal n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> "TRUE"
    *       | "FALSE"
    */
   public R visit(boolean_literal n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * const_exp -> const_exp()
    */
   public R visit(positive_int_const n, A argu) {
      R _ret=null;
      n.const_exp.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> "typedef" type_declarator()
    *       | struct_type()
    *       | union_type()
    *       | enum_type()
    */
   public R visit(type_dcl n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * type_spec -> type_spec()
    * declarators -> declarators()
    */
   public R visit(type_declarator n, A argu) {
      R _ret=null;
      n.type_spec.accept(this, argu);
      n.declarators.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> simple_type_spec()
    *       | constr_type_spec()
    */
   public R visit(type_spec n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> base_type_spec()
    *       | template_type_spec()
    *       | scoped_name()
    */
   public R visit(simple_type_spec n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> floating_pt_type()
    *       | integer_type()
    *       | char_type()
    *       | boolean_type()
    *       | octet_type()
    *       | any_type()
    */
   public R visit(base_type_spec n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> sequence_type()
    *       | string_type()
    */
   public R visit(template_type_spec n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> struct_type()
    *       | union_type()
    *       | enum_type()
    */
   public R visit(constr_type_spec n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * declarator -> declarator()
    * nodeListOptional -> ( "," declarator() )*
    */
   public R visit(declarators n, A argu) {
      R _ret=null;
      n.declarator.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> complex_declarator()
    *       | simple_declarator()
    */
   public R visit(declarator n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * identifier -> identifier()
    */
   public R visit(simple_declarator n, A argu) {
      R _ret=null;
      n.identifier.accept(this, argu);
      return _ret;
   }

   /**
    * array_declarator -> array_declarator()
    */
   public R visit(complex_declarator n, A argu) {
      R _ret=null;
      n.array_declarator.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> "float"
    *       | "double"
    */
   public R visit(floating_pt_type n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> signed_int()
    *       | unsigned_int()
    */
   public R visit(integer_type n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> signed_long_long_int()
    *       | signed_long_double_int()
    *       | signed_long_int()
    *       | signed_short_int()
    */
   public R visit(signed_int n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "long"
    */
   public R visit(signed_long_int n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "short"
    */
   public R visit(signed_short_int n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "long"
    * nodeToken1 -> "long"
    */
   public R visit(signed_long_long_int n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "long"
    * nodeToken1 -> "double"
    */
   public R visit(signed_long_double_int n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> unsigned_long_long_int()
    *       | unsigned_long_int()
    *       | unsigned_short_int()
    */
   public R visit(unsigned_int n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "unsigned"
    * nodeToken1 -> "long"
    */
   public R visit(unsigned_long_int n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "unsigned"
    * nodeToken1 -> "short"
    */
   public R visit(unsigned_short_int n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "unsigned"
    * nodeToken1 -> "long"
    * nodeToken2 -> "long"
    */
   public R visit(unsigned_long_long_int n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "char"
    */
   public R visit(char_type n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "boolean"
    */
   public R visit(boolean_type n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "octet"
    */
   public R visit(octet_type n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "any"
    */
   public R visit(any_type n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "struct"
    * identifier -> identifier()
    * nodeToken1 -> "{"
    * member_list -> member_list()
    * nodeToken2 -> "}"
    */
   public R visit(struct_type n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.member_list.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      return _ret;
   }

   /**
    * nodeList -> ( member() )+
    */
   public R visit(member_list n, A argu) {
      R _ret=null;
      n.nodeList.accept(this, argu);
      return _ret;
   }

   /**
    * type_spec -> type_spec()
    * declarators -> declarators()
    * nodeToken -> ";"
    */
   public R visit(member n, A argu) {
      R _ret=null;
      n.type_spec.accept(this, argu);
      n.declarators.accept(this, argu);
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "union"
    * identifier -> identifier()
    * nodeToken1 -> "switch"
    * nodeToken2 -> "("
    * switch_type_spec -> switch_type_spec()
    * nodeToken3 -> ")"
    * nodeToken4 -> "{"
    * switch_body -> switch_body()
    * nodeToken5 -> "}"
    */
   public R visit(union_type n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.switch_type_spec.accept(this, argu);
      n.nodeToken3.accept(this, argu);
      n.nodeToken4.accept(this, argu);
      n.switch_body.accept(this, argu);
      n.nodeToken5.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> integer_type()
    *       | char_type()
    *       | boolean_type()
    *       | enum_type()
    *       | scoped_name()
    */
   public R visit(switch_type_spec n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeList -> ( casex() )+
    */
   public R visit(switch_body n, A argu) {
      R _ret=null;
      n.nodeList.accept(this, argu);
      return _ret;
   }

   /**
    * nodeList -> ( case_label() )+
    * element_spec -> element_spec()
    * nodeToken -> ";"
    */
   public R visit(casex n, A argu) {
      R _ret=null;
      n.nodeList.accept(this, argu);
      n.element_spec.accept(this, argu);
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> "case" const_exp() ":"
    *       | "default" ":"
    */
   public R visit(case_label n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * type_spec -> type_spec()
    * declarator -> declarator()
    */
   public R visit(element_spec n, A argu) {
      R _ret=null;
      n.type_spec.accept(this, argu);
      n.declarator.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "enum"
    * identifier -> identifier()
    * nodeToken1 -> "{"
    * enumerator -> enumerator()
    * nodeListOptional -> ( "," enumerator() )*
    * nodeToken2 -> "}"
    */
   public R visit(enum_type n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.enumerator.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      return _ret;
   }

   /**
    * identifier -> identifier()
    */
   public R visit(enumerator n, A argu) {
      R _ret=null;
      n.identifier.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "sequence"
    * nodeToken1 -> "<"
    * simple_type_spec -> simple_type_spec()
    * nodeOptional -> [ "," positive_int_const() ]
    * nodeToken2 -> ">"
    */
   public R visit(sequence_type n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.simple_type_spec.accept(this, argu);
      n.nodeOptional.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> "string" [ "<" positive_int_const() ">" ]
    *       | "wstring" [ "<" positive_int_const() ">" ]
    */
   public R visit(string_type n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * identifier -> identifier()
    * nodeList -> ( fixed_array_size() )+
    */
   public R visit(array_declarator n, A argu) {
      R _ret=null;
      n.identifier.accept(this, argu);
      n.nodeList.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "["
    * positive_int_const -> positive_int_const()
    * nodeToken1 -> "]"
    */
   public R visit(fixed_array_size n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.positive_int_const.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      return _ret;
   }

   /**
    * nodeOptional -> [ "readonly" ]
    * nodeToken -> "attribute"
    * param_type_spec -> param_type_spec()
    * simple_declarator -> simple_declarator()
    * nodeListOptional -> ( "," simple_declarator() )*
    */
   public R visit(attr_dcl n, A argu) {
      R _ret=null;
      n.nodeOptional.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.param_type_spec.accept(this, argu);
      n.simple_declarator.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "exception"
    * identifier -> identifier()
    * nodeOptional -> ( "{" )?
    * nodeListOptional -> ( member() | "exception_body" )*
    * nodeOptional1 -> ( "}" )?
    */
   public R visit(except_dcl n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeOptional.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      n.nodeOptional1.accept(this, argu);
      return _ret;
   }

   /**
    * nodeOptional -> [ op_attribute() ]
    * op_type_spec -> op_type_spec()
    * identifier -> identifier()
    * parameter_dcls -> parameter_dcls()
    * nodeOptional1 -> [ raises_expr() ]
    * nodeOptional2 -> [ context_expr() ]
    */
   public R visit(op_dcl n, A argu) {
      R _ret=null;
      n.nodeOptional.accept(this, argu);
      n.op_type_spec.accept(this, argu);
      n.identifier.accept(this, argu);
      n.parameter_dcls.accept(this, argu);
      n.nodeOptional1.accept(this, argu);
      n.nodeOptional2.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "oneway"
    */
   public R visit(op_attribute n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> param_type_spec()
    *       | "void"
    */
   public R visit(op_type_spec n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "("
    * nodeOptional -> [ param_dcl() ( "," param_dcl() )* ]
    * nodeToken1 -> ")"
    */
   public R visit(parameter_dcls n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.nodeOptional.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      return _ret;
   }

   /**
    * param_attribute -> param_attribute()
    * param_type_spec -> param_type_spec()
    * simple_declarator -> simple_declarator()
    */
   public R visit(param_dcl n, A argu) {
      R _ret=null;
      n.param_attribute.accept(this, argu);
      n.param_type_spec.accept(this, argu);
      n.simple_declarator.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> "in"
    *       | "out"
    *       | "inout"
    */
   public R visit(param_attribute n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "raises"
    * nodeToken1 -> "("
    * scoped_name -> scoped_name()
    * nodeListOptional -> ( "," scoped_name() )*
    * nodeToken2 -> ")"
    */
   public R visit(raises_expr n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.scoped_name.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> "context"
    * nodeToken1 -> "("
    * string_literal -> string_literal()
    * nodeListOptional -> ( "," string_literal() )*
    * nodeToken2 -> ")"
    */
   public R visit(context_expr n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.string_literal.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> base_type_spec()
    *       | string_type()
    *       | scoped_name()
    */
   public R visit(param_type_spec n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> <ID>
    */
   public R visit(identifier n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> <OCTALINT>
    *       | <DECIMALINT>
    *       | <HEXADECIMALINT>
    */
   public R visit(integer_literal n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> <STRING>
    */
   public R visit(string_literal n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeToken -> <CHARACTER>
    */
   public R visit(character_literal n, A argu) {
      R _ret=null;
      n.nodeToken.accept(this, argu);
      return _ret;
   }

   /**
    * nodeChoice -> <FLOATONE>
    *       | <FLOATTWO>
    */
   public R visit(floating_pt_literal n, A argu) {
      R _ret=null;
      n.nodeChoice.accept(this, argu);
      return _ret;
   }

}
