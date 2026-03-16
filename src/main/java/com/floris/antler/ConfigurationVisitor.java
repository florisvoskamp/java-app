package com.floris.antler;// Generated from /home/floris/Documents/Repositories/College/Y3/APP/app/src/main/java/com/floris/antler/Configuration.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConfigurationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConfigurationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(ConfigurationParser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(ConfigurationParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ConfigurationParser.ValueContext ctx);
}