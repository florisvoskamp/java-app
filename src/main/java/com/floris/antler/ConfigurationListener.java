package com.floris.antler;// Generated from /home/floris/Documents/Repositories/College/Y3/APP/app/src/main/java/com/floris/antler/Configuration.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConfigurationParser}.
 */
public interface ConfigurationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#properties}.
	 * @param ctx the parse tree
	 */
	void enterProperties(ConfigurationParser.PropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#properties}.
	 * @param ctx the parse tree
	 */
	void exitProperties(ConfigurationParser.PropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(ConfigurationParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(ConfigurationParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ConfigurationParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ConfigurationParser.ValueContext ctx);
}