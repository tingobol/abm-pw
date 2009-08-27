<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Compras
    Created on : Aug 26, 2009, 11:30:55 PM
    Author     : markos
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <df:ajaxTransaction id="ajaxTransaction1"
                        inputs="page1:html1:body1:form1:gridPanelDown1:gridPanelForm1:dropDownProveedor,page1:html1:body1:form1:gridPanelDown1:gridPanelForm:dropDownProveedor" render="page1:html1:body1:form1:gridPanelDown1:gridPanelForm1:dropDownProducto,page1:html1:body1:form1:gridPanelDown1:gridPanelForm:dropDownProducto"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <h:panelGrid id="gridPanelContent1" style="left: 0px; top: 48px; position: absolute" styleClass="panelContent">
                            <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true" style="width: 450px"
                                title="COMPRAS" width="450">
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:label id="lblFiltro1" text="Busqueda"/>
                                        <webuijsf:textField binding="#{Compras.txtFiltro}" id="txtFiltro"/>
                                        <webuijsf:dropDown binding="#{Compras.dropDownFiltro}" id="dropDownFiltro" items="#{Productos.opcionFiltro}"/>
                                        <webuijsf:button actionExpression="#{Compras.btnBuscar_action}" alt="Filtro" binding="#{Compras.btnBuscar}"
                                            id="btnBuscar" text="Buscar" toolTip="Filtro"/>
                                        <webuijsf:button actionExpression="#{Compras.botonLimpiar_action}" binding="#{Compras.botonLimpiar}" id="botonLimpiar" text="Limpiar"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                                <webuijsf:tableRowGroup binding="#{Compras.tableRowGroup}" id="tableRowGroup" rows="5" selected="#{Compras.selectedState}"
                                    sourceData="#{Compras.listaCompras}" sourceVar="currentRow">
                                    <webuijsf:tableColumn headerText="Código" id="tableColumn1" sort="idcompra">
                                        <webuijsf:staticText id="staticText1" text="#{currentRow.value['idcompra']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Producto" id="tableColumn2" sort="nombre">
                                        <webuijsf:staticText id="staticText2" text="#{currentRow.value['idproducto'].nombre}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Cantidad" id="tableColumn3" sort="cantidad">
                                        <webuijsf:staticText id="staticText3" text="#{currentRow.value['cantidad']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Proveedor" id="tableColumn4" sort="nombre">
                                        <webuijsf:staticText id="staticText4" text="#{currentRow.value['idproveedor'].nombre}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn5" sort="column3">
                                        <webuijsf:button actionExpression="#{Compras.botonModificar_action}" id="botonModificar1" text="Modificar"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn6" sort="column4">
                                        <webuijsf:button actionExpression="#{Compras.botonEliminar_action}" id="botonEliminar1" text="Eliminar"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:button actionExpression="#{Compras.botonInsertar1_action}" binding="#{Compras.botonInsertar1}" id="botonInsertar1" text="Insertar"/>
                        </h:panelGrid>
                        <webuijsf:messageGroup id="messageGroup1" style="left: 0px; top: 0px; position: absolute" title="SCS"/>
                        <h:panelGrid id="gridPanelDown1" style="left: 0px; top: 216px; position: absolute">
                            <h:panelGrid binding="#{Compras.gridPanelForm}" columns="2" id="gridPanelForm">
                                <webuijsf:label id="label1" text="Detalle : "/>
                                <webuijsf:textField binding="#{Compras.txtDetalle}" columns="50" id="txtDetalle"/>
                                <webuijsf:label id="label2" text="Nombre  : "/>
                                <webuijsf:textField binding="#{Compras.txtNombre}" id="txtNombre"/>
                                <webuijsf:label id="label4" text="Proveedor : "/>
                                <webuijsf:dropDown binding="#{Compras.dropDownProveedor}" id="dropDownProveedor" items="#{Compras.listaProveedoresOption}"
                                    onChange="DynaFaces.Tx.fire('ajaxTransaction1', 'dropDownProveedor');"
                                    valueChangeListenerExpression="#{Compras.dropDownProveedor_processValueChange}"/>
                                <webuijsf:label id="label5" text="Producto : "/>
                                <webuijsf:dropDown binding="#{Compras.dropDownProducto}" id="dropDownProducto" items="#{Compras.listaProductosOption}"/>
                                <webuijsf:label id="label3" text="Cantidad  : "/>
                                <webuijsf:textField binding="#{Compras.txtCantidad}" id="txtCantidad"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{Compras.gridPanelBotones}" columns="3" id="gridPanelBotones" width="168">
                                <webuijsf:button actionExpression="#{Compras.btnAceptar_action}" binding="#{Compras.btnAceptar}" id="btnAceptar" text="Aceptar"/>
                                <webuijsf:button actionExpression="#{Compras.btnUpdate_action}" binding="#{Compras.btnUpdate}" id="btnUpdate" text="Actualizar"/>
                                <webuijsf:button actionExpression="#{Compras.btnCancelar_action}" binding="#{Compras.btnCancelar}" id="btnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
