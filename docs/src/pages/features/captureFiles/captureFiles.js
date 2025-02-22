import DeepChatBrowser from '../../../components/table/deepChatBrowser';
import OnVisibleAnimation from '../../utils/onVisibleAnimation';
import './captureFiles.css';
import React from 'react';

function RightPanel() {
  return (
    <div id="capture-files-right-panel" className="feature-panel">
      <div className="capture-files-text">
        Deep Chat can be used to archive chat data, helping organizations to learn how to provider better service to
        customers
      </div>
    </div>
  );
}

function LeftPanel() {
  return (
    <div id="capture-files-left-panel" className="feature-panel">
      <DeepChatBrowser
        demo={true}
        introMessage={`Click the camera or the microphone button.`}
        history={[
          {files: [{src: '/img/cat.jpg', type: 'image'}], role: 'user'},
          {files: [{src: '/audio/jeff.mp3', type: 'audio'}], role: 'ai'},
        ]}
        style={{
          borderRadius: '10px',
          boxShadow: '0 .5rem 1rem 0 rgba(44, 51, 73, .1)',
          border: '1px solid #ededed',
        }}
        camera={{button: {styles: {container: {default: {marginRight: '2px'}}}}}}
        microphone={{button: {styles: {container: {default: {marginLeft: '4px'}}}}}}
        textInput={{styles: {container: {width: '75%'}}}}
      ></DeepChatBrowser>
    </div>
  );
}

export default function CaptureFiles() {
  return (
    <div>
      <div id="capture-files-sub-header" className="feature-sub-header">
        Make Data Valuable for Organization
      </div>
      <div id="capture-files-panels">
        <OnVisibleAnimation beforeClass={'capture-panels-distributed'} afterClass={'capture-panels-close'} timeoutMS={0}>
          <OnVisibleAnimation>
            <LeftPanel></LeftPanel>
            <RightPanel></RightPanel>
          </OnVisibleAnimation>
        </OnVisibleAnimation>
      </div>
    </div>
  );
}
