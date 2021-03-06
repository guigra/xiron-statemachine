/*  
 * Copyright 2012 xavi.ferro
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package shisha.statemachine.annotations.util;

import shisha.statemachine.EventInfo;
import shisha.statemachine.TransitionInfo;
import shisha.statemachine.annotations.AStateMachine;
import shisha.statemachine.annotations.EnterState;
import shisha.statemachine.annotations.Event;
import shisha.statemachine.annotations.State;
import shisha.statemachine.annotations.Transition;
import shisha.statemachine.annotations.Transitions;

@AStateMachine
public class DumbRedirectController {
    @State(isStart = true) public static final String STATE_A = "STATE_A";
    @State public static final String STATE_B = "STATE_B";
    @State public static final String STATE_C = "STATE_C";
    
    @Event public static final String EVENT_AA = "EVENT_AA";
    @Event public static final String EVENT_AB = "EVENT_AB";
    @Event public static final String EVENT_BC = "EVENT_BC";

    @EnterState(STATE_B)
    public EventInfo transitionAB(TransitionInfo evt) {
        return new EventInfo(EVENT_BC, null);
    }

    @Transitions({@Transition(source = STATE_A, event = EVENT_AB, target = STATE_B),
            @Transition(source = STATE_A, event = EVENT_AA, target = STATE_A),
            @Transition(source = STATE_B, event = EVENT_BC, target = STATE_C)})
    public void noop(TransitionInfo evt) { }
}
