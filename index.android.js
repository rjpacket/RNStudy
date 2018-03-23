'use strict';
 import React from 'react';
 import {
   AppRegistry,
   StyleSheet,
   Text,
   View
 } from 'react-native';
 class Btn extends React.Component{
    render() {
        return (
            <Text style={styles.hello}>Hello {this.props.name}</Text>
        );
    }
 }

 class HelloWorld extends React.Component {
   render() {
     return (
       <View style={styles.container}>
         <Text style={styles.hello}>Hi!第一个项目诞生了！</Text>
         <Btn name="rjp1"></Btn>
         <Btn name="rjp2"></Btn>
         <Btn name="rjp3"></Btn>
         <Btn name="rjp2"></Btn>
         <Btn name="rjp1"></Btn>
       </View>
     )
   }
 }

 var styles = StyleSheet.create({
   container: {
     flex: 1,
     justifyContent: 'center',
   },
   hello: {
     fontSize: 20,
     textAlign: 'center',
     margin: 10,
   },
 });
 AppRegistry.registerComponent('HelloWorld', () => HelloWorld);