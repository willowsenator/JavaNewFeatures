package org.willowsenator.sealed;

public sealed interface SmartMediaPlayer permits Car{
    void connectPhone();
}
