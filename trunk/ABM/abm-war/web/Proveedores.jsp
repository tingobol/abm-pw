<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Proveedores
    Created on : Aug 26, 2009, 11:24:54 PM
    Author     : markos
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <h:panelGrid id="gridPanelContent1" style="left: 0px; top: 48px; position: absolute" styleClass="panelContent">
                            <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true" style="width: 450px"
                                title="PROVEEDORES" width="351">
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:label id="lblFiltro" text="Busqueda"/>
                                        <webuijsf:textField binding="#{Proveedores.txtFiltro}" id="txtFiltro"/>
                                        <webuijsf:dropDown binding="#{Proveedores.dropDownFiltro}" id="dropDownFiltro" items="#{Productos.opcionFiltro}"/>
                                        <webuijsf:button actionExpression="#{Proveedores.btnBuscar_action}" alt="Filtro" id="btnBuscar1" text="Buscar" toolTip="Filtro"/>
                                        <webuijsf:button actionExpression="#{Proveedores.botonLimpiar_action}" id="botonLimpiar" text="Limpiar"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                                <webuijsf:tableRowGroup binding="#{Proveedores.tableRowGroup}" id="tableRowGroup" rows="5"
                                    selected="#{Proveedores.selectedState}" sourceData="#{Proveedores.listaProveedores}" sourceVar="currentRow">
                                    <webuijsf:tableColumn headerText="Código" id="tableColumn1" sort="codigo">
                                        <webuijsf:staticText id="staticText1" text="#{currentRow.value['codigo']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Nombre" id="tableColumn2" sort="nombre">
                                        <webuijsf:staticText id="staticText2" text="#{currentRow.value['nombre']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn5" sort="column3">
                                        <webuijsf:button actionExpression="#{Proveedores.botonModificar_action}" id="botonModificar" text="Modificar"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn6" sort="column4">
                                        <webuijsf:button actionExpression="#{Proveedores.botonEliminar_action}" id="botonEliminar" text="Eliminar"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:button actionExpression="#{Proveedores.botonInsertar1_action}" id="botonInsertar1" text="Insertar"/>
                        </h:panelGrid>
                        <h:panelGrid binding="#{Proveedores.gridPanelForm}" columns="2" id="gridPanelForm" style="left: 0px; top: 216px; position: absolute">
                            <webuijsf:label id="label1" text="Nombre : "/>
                            <webuijsf:textField binding="#{Proveedores.txtNombre}" id="txtNombre"/>
                            <webuijsf:label id="label2" text="Direccion  : "/>
                            <webuijsf:textField binding="#{Proveedores.txtDireccion}" id="txtDireccion"/>
                            <webuijsf:label id="label3" text="Telefono  : "/>
                            <webuijsf:textField binding="#{Proveedores.txtTelefono}" id="txtTelefono"/>
                        </h:panelGrid>
                        <webuijsf:messageGroup id="messageGroup1" style="left: 0px; top: 0px; position: absolute" title="SCS"/>
                        <h:panelGrid binding="#{Proveedores.gridPanelBotones}" columns="3" id="gridPanelBotones" style="position: absolute; left: 24px; top: 312px">
                            <webuijsf:button actionExpression="#{Proveedores.btnAceptar_action}" binding="#{Proveedores.btnAceptar}" id="btnAceptar" text="Aceptar"/>
                            <webuijsf:button actionExpression="#{Proveedores.btnUpdate_action}" binding="#{Proveedores.btnUpdate}" id="btnUpdate" text="Actualizar"/>
                            <webuijsf:button actionExpression="#{Proveedores.btnCancelar_action}" binding="#{Proveedores.btnCancelar}" id="btnCancelar" text="Cancelar"/>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
