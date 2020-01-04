﻿// -*- C++ -*-
/*!
 * @file  ModuleNameFSM.cpp
 * @date $Date$
 * $Id$
 */

#include "ModuleNameFSM.h"

namespace ModuleNameFsm {

// Top state
RTC::ReturnCode_t Top::onInit() {
  setState<State01>();
  return RTC::RTC_OK;
}

RTC::ReturnCode_t Top::onEntry() {
  return RTC::RTC_OK;
}

RTC::ReturnCode_t Top::onExit() {
  return RTC::RTC_OK;
}

//============================================================
// State State01
// RTC::ReturnCode_t State01::onInit() {
//   return RTC::RTC_OK;
// }


void State01::Event01-02(RTC::TimedLong data) {
  setState<State02>();
}


//============================================================
// State State02
// RTC::ReturnCode_t State02::onInit() {
//   return RTC::RTC_OK;
// }


void State02::Event02-Final(RTC::TimedString data) {
  setState<FinalState>();
}


} //end namespace 'ModuleNameFSM'
